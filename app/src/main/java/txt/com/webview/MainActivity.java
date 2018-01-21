package txt.com.webview;

import android.support.v7.app.AppCompatActivity;
//package devpro.com.webviewdemo;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {
    Button btnGo;
    EditText edtUrl;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Khai báo button và edittext
        btnGo = (Button) findViewById(R.id.btnGo);
        edtUrl = (EditText) findViewById(R.id.edtUrl);
        //khởi tạo webview
        webView = (WebView) findViewById(R.id.wvDemo);
        webView.setWebViewClient(new MyBrowser());
        //sự kiện click cho button
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy địa chỉ ở edittext và load webview
                String url = edtUrl.getText().toString();
                webView.getSettings().setLoadsImagesAutomatically(true);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                webView.loadUrl(url);
            }
        });
    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
