package com.example.capstoneapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.capstoneapp.ui.theme.TextGrayColor
import com.example.capstoneapp.utils.Constants

@Composable
fun HorizontalBookCard(
    onClick: ()-> Unit = {},
    book: com.example.capstoneapp.models.Item
){

    val coverBookImage: String = book.volumeInfo.imageLinks.smallThumbnail.ifEmpty { Constants.DEFAULTCOVERBOOK }
    Box(
        modifier = Modifier
            .height(60.dp)
            .width(150.dp)
            .clickable { onClick() }
    ){
        Row {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(coverBookImage)
                    .crossfade(true)
                    .build(),
                modifier = Modifier
                    .fillMaxHeight()
                    .width(60.dp)
                    .clip(shape = CircleShape.copy(all = CornerSize(5.dp))),
                placeholder = BrushPainter(
                    Brush.linearGradient(
                        listOf(
                            Color(color = 0xFFFFFFFF),
                            Color(color = 0xFFDDDDDD),
                        )
                    )),
                contentDescription = "cover of book: ${book.volumeInfo.title}",
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text=book.volumeInfo.title,
                    style = TextStyle(
                        color = Color.Black.copy(alpha = 0.7f),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                        )
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text="By:${book.volumeInfo.authors}",
                    style = TextStyle(
                        fontSize = 10.sp,
                        color = TextGrayColor
                    )
                )
            }
        }
    }
}