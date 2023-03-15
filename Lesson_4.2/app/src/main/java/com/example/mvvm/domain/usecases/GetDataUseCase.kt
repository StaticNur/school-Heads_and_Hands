package com.example.mvvm.domain.usecases

import com.example.mvvm.R
import com.example.mvvm.utils.LoadException
import ru.handh.ekf.smarthome.feature.main.impl.data.repository.Author
import ru.handh.ekf.smarthome.feature.main.impl.data.repository.Book
import ru.handh.ekf.smarthome.feature.main.impl.data.repository.BookAvailability
import ru.handh.ekf.smarthome.feature.main.impl.data.repository.MockRepository

class GetDataUseCase(private val mockRepository: MockRepository) {

    suspend fun getAuthors() : List<Author> {
        return mockRepository.getAuthors().getOrElse {
            throw LoadException(R.string.error_get_authors)
        }
    }

    suspend fun getBooks() : List<Book> {
        return mockRepository.getBooks().getOrElse {
            throw LoadException(R.string.error_get_books)
        }

    }

    suspend fun getAvailability() : List<BookAvailability> {
        return mockRepository.getAvailability().getOrElse {
            throw LoadException(R.string.error_get_availability)
        }
    }

}