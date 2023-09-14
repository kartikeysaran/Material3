package kartikey.saran.material3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kartikey.saran.material3.ui.theme.Material3Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3Theme {
                Scaffold(
                    floatingActionButton = {
                        FloatingActionButton(onClick = { }, shape = MaterialTheme.shapes.large) {
                            Icon(imageVector = Icons.Default.Build , contentDescription = null, tint = MaterialTheme.colorScheme.onPrimaryContainer)
                        }
                    },
                    topBar = {
                      TopAppBar(title = {
                          Text(text = "Material 3 Tutorial")
                      }, colors = TopAppBarDefaults.topAppBarColors(
                          containerColor = MaterialTheme.colorScheme.surfaceVariant,
                          titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                      ))
                    }
                ) { v->
                    val title = "Lorem Ipsum"
                    val description = "Lorem Ipsum Lorem IpsumLorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum"
                    LazyColumn(contentPadding = v){
                        items(20) {
                            val modalSheetState = rememberModalBottomSheetState()
                            var isSheetOpen by rememberSaveable{
                                mutableStateOf(false)
                            }
                            ImageCard(title = title, description = description,
                                Modifier.padding(16.dp).clickable {
                                    isSheetOpen = true
                                })

                            if(isSheetOpen) {
                                ModalBottomSheet(onDismissRequest = {
                                   isSheetOpen = false
                                }, sheetState = modalSheetState) {
                                    ImageCard(title = title, description = description)
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Material3Theme {

    }
}