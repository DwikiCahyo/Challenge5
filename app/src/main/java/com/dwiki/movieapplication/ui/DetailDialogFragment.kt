package com.dwiki.movieapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.dwiki.movieapplication.R
import java.util.*

class DetailDialogFragment(
    val title:String,
    val releaseDate:String,
    val overview:String,
    val imagePath:String
):DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        return inflater.inflate(R.layout.layout_dialog_fragment,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvTitle = view.findViewById<TextView>(R.id.tv_title)
        val tvReleaseDate = view.findViewById<TextView>(R.id.tv_release_date)
        val tvOverview = view.findViewById<TextView>(R.id.tv_overview)
        val tvImagePath = view.findViewById<ImageView>(R.id.iv_poster_image)

        tvTitle.text = title
        tvReleaseDate.text = "Release Date : $releaseDate"
        tvOverview.text = overview
        Glide.with(requireContext()).load("https://image.tmdb.org/t/p/w500/$imagePath").into(tvImagePath)


    }
}