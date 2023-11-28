package com.adoyo.orbitallibrarry.presentation

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.adoyo.orbitallibrarry.model.Character
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.animation.crossfade.CrossfadePlugin
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.orbital.Orbital
import com.skydoves.orbital.animateBounds
import com.skydoves.orbital.rememberMovableContentOf

@Composable
fun CharacterScreen(
    characters: LazyPagingItems<Character>
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = characters.loadState) {
        if (characters.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error:" + (characters.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if (characters.loadState.refresh is LoadState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            Orbital {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(characters.itemCount) { character ->
                        var expanded by rememberSaveable {
                            mutableStateOf(false)
                        }
                        AnimatedVisibility(
                            remember {
                                MutableTransitionState(false)
                            }.apply { targetState = true },
                            enter = fadeIn()
                        ) {
                            Orbital(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { expanded = !expanded }
                                    .background(
                                        color = Color.Transparent,
                                        shape = RoundedCornerShape(10.dp)
                                    )
                            ) {
                                val title = rememberMovableContentOf {
                                    Column(
                                        modifier = Modifier
                                            .padding(10.dp)
                                            .animateBounds(Modifier)
                                    ) {
                                        characters[character]?.name?.let {
                                            Text(
                                                text = it,
                                                fontSize = 18.sp,
                                                color = Color.Black,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }

                                    }
                                }

                                var image = rememberMovableContentOf {
                                    com.skydoves.landscapist.glide.GlideImage(
                                        imageModel = { characters[character]?.imageUrl },
                                        component = rememberImageComponent {
                                            +CrossfadePlugin()
                                        },
                                        modifier = Modifier
                                            .padding(10.dp)
                                            .animateBounds(
                                                if (expanded) {
                                                    Modifier.fillMaxWidth()
                                                } else {
                                                    Modifier.size(80.dp)
                                                },
                                                spring(stiffness = Spring.StiffnessLow)
                                            )
                                            .clip(RoundedCornerShape(10.dp)),
                                        imageOptions = ImageOptions(
                                            requestSize = IntSize(600, 600)
                                        )
                                    )
                                }
                                if (expanded) {
                                    Column {
                                        image()
                                        title()
                                    }
                                } else {
                                    Row {
                                        image()
                                        title()
                                    }
                                }

                            }
                        }

//                        CharacterItem(
//                            character = characters[character]!!,
//                            modifier = Modifier.fillMaxWidth()
//                        )
                    }
                    item {
                        if (characters.loadState.append is LoadState.Loading) {
                            CircularProgressIndicator()
                        }
                    }

                }

            }
        }
    }

}