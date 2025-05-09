package com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.navigation.SetupNavGraph
import com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.ui.theme.Packagecomghinafadiyahhr6070623000001assessment2Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Packagecomghinafadiyahhr6070623000001assessment2Theme{
                SetupNavGraph()
            }
        }
    }
}

