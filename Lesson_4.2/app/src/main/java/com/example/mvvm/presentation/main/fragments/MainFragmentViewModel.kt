package com.example.mvvm.presentation.main.fragments

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.presentation.main.model.AuthorModel
import com.example.mvvm.domain.usecases.GetDataUseCase
import com.example.mvvm.utils.LoadException
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import ru.handh.ekf.smarthome.feature.main.impl.data.repository.Author
import ru.handh.ekf.smarthome.feature.main.impl.data.repository.Book
import ru.handh.ekf.smarthome.feature.main.impl.data.repository.BookAvailability
import ru.handh.ekf.smarthome.feature.main.impl.data.repository.MockRepository

sealed class BookListUiState {

    class Loading : BookListUiState()
    class Success(val authorModelList: List<AuthorModel>) : BookListUiState()
    class Error(val errorMessage: Int) : BookListUiState()
}

class MainFragmentViewModel : ViewModel() {


    private val _uiState: MutableStateFlow<BookListUiState> =
        MutableStateFlow(BookListUiState.Loading())
    val uiState: StateFlow<BookListUiState> = _uiState

    private val getDataUseCase = GetDataUseCase(MockRepository())

    init {
        loadData()
    }

    fun loadData() {
        _uiState.update {
            BookListUiState.Loading()
        }
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val authorsList = withContext(Dispatchers.IO) {
                    getDataUseCase.getAuthors().sortedBy { it.name }
                }
                val booksList = withContext(Dispatchers.IO) {
                    getDataUseCase.getBooks().sortedBy { it.title }
                }
                val availabilityList = withContext(Dispatchers.IO) {
                    getDataUseCase.getAvailability()
                }

                _uiState.update {
                    BookListUiState.Success(
                        createAuthorModel(
                            authorsList,
                            booksList,
                            availabilityList
                        )
                    )
                }

            } catch (e: LoadException) {
                _uiState.update {
                    BookListUiState.Error(e.errorMessage)
                }
                Log.d("DataLoading", "Data loading error")
            }
        }
    }


    private fun createAuthorModel(
        authorList: List<Author>,
        bookList: List<Book>,
        availabilityList: List<BookAvailability>
    ): List<AuthorModel> {
        val bookMap = bookList.groupBy {
            it.authorId
        }
        return authorList.map { author ->
            val books = bookMap[author.authorId] ?: emptyList()
            val bookStrings = books.map { book ->
                val availability = availabilityList.firstOrNull { it.bookId == book.bookId }
                "${book.title} (${availability?.let { if (it.inStock) " в наличии" else " нет в наличии" } ?: " нет информации о наличии"})"
            }
            AuthorModel(author.name, bookStrings)
        }
    }

}