package com.example.capstoneapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.capstoneapp.models.Item
import com.example.capstoneapp.ui.theme.BackgroundColor
import com.example.capstoneapp.ui.theme.BlueColor
import com.example.capstoneapp.ui.theme.OrangeColor
import com.example.capstoneapp.ui.theme.TextGrayColor
import com.example.capstoneapp.utils.Constants

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DetailBookCard (
    book: Item
){
    val coverBookImage: String = book.volumeInfo.imageLinks.thumbnail.ifBlank { Constants.DEFAULTCOVERBOOK }

    Box(
        modifier = Modifier
            .height(300.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Box (
                modifier = Modifier
                    .width(200.dp)
            ){
                Surface(
                    color = BlueColor,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .height(280.dp)
                        .fillMaxSize()
                ) {}
                Surface(
                    color = BackgroundColor,
                    modifier = Modifier
                        .padding(top = 15.dp, end = 15.dp, bottom = 5.dp)
                        .fillMaxSize(),
                    border = BorderStroke(width = 1.dp, color = TextGrayColor )
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(coverBookImage)
                            .crossfade(true)
                            .build(),
                        placeholder = BrushPainter(
                            Brush.linearGradient(
                                listOf(
                                    Color(color = 0xFFFFFFFF),
                                    Color(color = 0xFFDDDDDD),
                                )
                            )),
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        contentDescription = null,
                    )
                }
            }
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize()
            ) {
                Text(
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    text = book.volumeInfo.title,
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black.copy(alpha = 0.85f)
                    )
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "By: ${book.volumeInfo.authors}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = TextGrayColor
                    )
                )
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        Icons.Default.Star,
                        contentDescription = null,
                        tint = OrangeColor,
                        modifier = Modifier.size(20.dp)
                        )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "${book.volumeInfo.averageRating} ( ${book.volumeInfo.ratingsCount} Review )",
                        style = TextStyle(
                            fontSize = 13.sp,
                            color = Color.Black.copy(alpha = 0.85f)
                        )
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                FlowRow(
                    Modifier
                        .padding(5.dp)
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    verticalArrangement = Arrangement.spacedBy(2.dp),
                    maxItemsInEachRow = 2,
                ) {
                    repeat(if(book.volumeInfo.categories.size > 4) 4 else book.volumeInfo.categories.size) { index->
                        val category: String = book.volumeInfo.categories[index]
                        Card(
                            modifier = Modifier.padding(2.dp),
                            colors =  CardDefaults.cardColors(
                                containerColor = TextGrayColor.copy(alpha = 0.4f)
                            ),
                            shape = CircleShape.copy(all = CornerSize(2.dp))
                        ){
                            Text(
                                maxLines = 1,
                                overflow = TextOverflow.Clip,
                                modifier = Modifier.padding(5.dp),
                                text=category,
                                style = TextStyle(
                                    color = Color.Gray,
                                    fontSize = 10.sp
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}