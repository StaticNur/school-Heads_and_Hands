package com.example.lesson_24

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson_24.adapter.RecyclerAdapter

class FragmentLife : Fragment() {
    val array = ArrayList<String>()
    var recyclerViewFragment: RecyclerView? = null
    val TAG = FragmentLife::class.java.toString()


    override fun onAttach(context: Context) {
        super.onAttach(context)
        array.add("onAttach")
        Log.d(TAG, "Fragment: onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        array.add("onCreate")
        Log.d(TAG, "Fragment: onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment, container, false)
        array.add("onCreateView")
        Log.d(TAG, "Fragment: onCreateView")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewFragment = view.findViewById(R.id.recyclerView_fragment)
        recyclerViewFragment!!.layoutManager = GridLayoutManager(context, 1)

        array.add("onViewCreated")
        Log.d(TAG, "Fragment: onViewCreated")
        refreshAdapter(array)
    }

    fun refreshAdapter(arr: ArrayList<String>) {
        val adaptor = context?.let { RecyclerAdapter(it, arr) }
        recyclerViewFragment!!.adapter = adaptor
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        array.add("onActivityCreated")
        Log.d(TAG, "Fragment: onActivityCreated")
        refreshAdapter(array)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        array.add("onViewStateRestored")
        Log.d(TAG, "Fragment: onViewStateRestored")
        refreshAdapter(array)
    }

    override fun onStart() {
        super.onStart()
        array.add("onStart")
        Log.d(TAG, "Fragment: onStart")
        refreshAdapter(array)
    }

    override fun onResume() {
        super.onResume()
        array.add("onResume")
        Log.d(TAG, "Fragment: onResume")
        refreshAdapter(array)
    }

    override fun onPause() {
        super.onPause()
        array.add("onPause")
        Log.d(TAG, "Fragment: onPause")
        refreshAdapter(array)
    }

    override fun onStop() {
        super.onStop()
        array.add("onStop")
        Log.d(TAG, "Fragment: onStop")
        refreshAdapter(array)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        array.add("onDestroyView")
        Log.d(TAG, "Fragment: onDestroyView")
        refreshAdapter(array)
    }

    override fun onDestroy() {
        super.onDestroy()
        array.add("onDestroy")
        Log.d(TAG, "Fragment: onDestroy")
        refreshAdapter(array)
    }

    override fun onDetach() {
        super.onDetach()
        array.add("onDetach")
        Log.d(TAG, "Fragment: onDetach")
        refreshAdapter(array)
    }
}
