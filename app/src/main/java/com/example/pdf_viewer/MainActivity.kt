package com.example.pdf_viewer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.barteksc.pdfviewer.PDFView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pdfViewer = findViewById<PDFView>(R.id.pdfView)

        pdfViewer.fromAsset("git_cheat_sheet.pdf")
            .password(null) // if password protected, then write password
            .defaultPage(0) // set the default page to open
            .onPageError { page, _ ->
                Toast.makeText(
                    this,
                    "Error at page: $page", Toast.LENGTH_LONG
                ).show()
            }
            .load()

    }
}