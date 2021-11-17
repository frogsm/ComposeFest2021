package com.frogsm.compose.mylayoutscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.frogsm.compose.mylayoutscodelab.ui.theme.MyLayoutsCodelabTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLayoutsCodelabTheme {
                // A surface container using the 'background' color from the theme
            }
        }
    }
}

@Composable
fun LayoutsCodelab() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "LayoutsCodelab")
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        BodyContent(Modifier.padding(innerPadding))
    }
}

@Preview
@Composable
fun LayoutsCodelabPreview() {
    MyLayoutsCodelabTheme {
        LayoutsCodelab()
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////
//@Composable
//fun BodyContent(modifier: Modifier = Modifier) {
//    Column(modifier = modifier.padding(8.dp)) {
//        Text(text = "Hi there!")
//        Text(text = "Thanks for going through the Layouts codelab!")
//    }
//}
//


//@Composable
//fun SimpleList() {
//    val scrollState = rememberScrollState()
//
//    Column(Modifier.verticalScroll(scrollState)) {
//        repeat(100) {
//            Text(text = "Item #$it")
//        }
//    }
//}
//
//@Composable
//fun LazyList() {
//    val scrollState = rememberLazyListState()
//
//    LazyColumn(state = scrollState) {
//        items(100) {
//            Text(text = "Item #$it")
//        }
//    }
//}
//
//@Composable
//fun ImageListItem(index: Int) {
//    Row(verticalAlignment = Alignment.CenterVertically) {
//        Image(
//            painter = rememberImagePainter(data = "https://developer.android.com/images/brand/Android_Robot.png"),
//            contentDescription = "Android Logo",
//            modifier = Modifier.size(50.dp)
//        )
//        Spacer(modifier = Modifier.width(10.dp))
//        Text(text = "Item #$index", style = MaterialTheme.typography.subtitle1)
//    }
//}
//
//@Composable
//fun ImageList() {
//    val scrollState = rememberLazyListState()
//
//    LazyColumn(state = scrollState) {
//        items(100) {
//            ImageListItem(it)
//        }
//    }
//}
//
//@Preview
//@Composable
//fun ScrollingList() {
//    val listSize = 100
//    val scrollState = rememberLazyListState()
//    val coroutineScope = rememberCoroutineScope()
//
//    Column {
//        Row {
//            Button(onClick = {
//                coroutineScope.launch {
//                    scrollState.animateScrollToItem(0)
//                }
//            }) {
//                Text(text = "Scroll to the top")
//            }
//
//            Button(onClick = {
//                coroutineScope.launch {
//                    scrollState.animateScrollToItem(listSize - 1)
//                }
//            }) {
//                Text(text = "Scroll to the end")
//            }
//        }
//
//        LazyColumn(state = scrollState) {
//            items(100) {
//                ImageListItem(it)
//            }
//        }
//    }
//}


////////////////////////////////////////////////////////////////////////////////////////////////////
//@Composable
//fun BodyContent(modifier: Modifier = Modifier) {
//    MyOwnColumn(modifier.padding(8.dp)) {
//        Text("MyOwnColumn")
//        Text("places items")
//        Text("vertically.")
//        Text("We've done it by hand!")
//    }
//}

////////////////////////////////////////////////////////////////////////////////////////////////////
//@Composable
//fun PhotographerCard() {
//    Row {
//        Surface(
//            modifier = Modifier.size(50.dp),
//            shape = CircleShape,
//            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
//        ) {
//
//        }
//        Column {
//            Text(text = "Alfred Sisley", fontWeight = FontWeight.Bold)
//            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
//                Text(text = "3 minutes ago", style = MaterialTheme.typography.body2)
//            }
//        }
//    }
//}
//
//@Preview
//@Composable
//fun PhotographerCardPreview() {
//    MyLayoutsCodelabTheme {
//        PhotographerCard()
//    }
//}