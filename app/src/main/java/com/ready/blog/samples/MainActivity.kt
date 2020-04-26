package com.ready.blog.samples

import android.annotation.TargetApi
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.text.method.ScrollingMovementMethod
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        web_view.webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                writeLog("onPageStarted : ${url}\n")
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                writeLog("onPageFinished : ${url}\n")
                super.onPageFinished(view, url)
            }

            override fun onLoadResource(view: WebView?, url: String?) {
                writeLog("onLoadResource : ${url}\n")
                super.onLoadResource(view, url)
            }

            @TargetApi(Build.VERSION_CODES.LOLLIPOP_MR1)
            override fun shouldInterceptRequest(
                view: WebView?,
                request: WebResourceRequest?
            ): WebResourceResponse? {
                writeLog("shouldInterceptRequest : ${request?.url.toString()}\n")
                return super.shouldInterceptRequest(view, request)
            }

            @TargetApi(Build.VERSION_CODES.N_MR1)
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                writeLog("shouldOverrideUrlLoading : ${request?.url.toString()}\n")
                return super.shouldOverrideUrlLoading(view, request)
            }
        }

        web_view.loadUrl("https://readystory.tistory.com/")
        log_text.movementMethod = ScrollingMovementMethod()
    }

    private fun writeLog(log: String) {
        handler.post {
            log_text.append(log)
        }
    }
}
