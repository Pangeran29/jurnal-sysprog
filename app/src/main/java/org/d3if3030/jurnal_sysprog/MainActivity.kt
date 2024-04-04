package org.d3if3030.jurnal_sysprog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import org.d3if3030.jurnal_sysprog.ui.screen.MainScreen
import org.d3if3030.jurnal_sysprog.ui.theme.Jurnal_sysprogTheme
import org.d3if3030.model.Book
import org.d3if3030.navigation.SetUpNavGraph

class MainActivity : ComponentActivity() {
    private val data = getData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jurnal_sysprogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SetUpNavGraph()
                }
            }
        }
    }

    private fun getData(): List<Book> {
        return listOf(
            Book("The Rust Programming Language", R.drawable.the_rust_programming_language)
        )
    }
}