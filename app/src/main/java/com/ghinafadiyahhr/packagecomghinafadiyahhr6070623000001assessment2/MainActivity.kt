package com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.screen.MainScreen
import com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.ui.theme.Packagecomghinafadiyahhr6070623000001assessment2Theme
import kotlinx.coroutines.MainScope

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Packagecomghinafadiyahhr6070623000001assessment2Theme {
               MainScreen()
                }
            }
        }
    }