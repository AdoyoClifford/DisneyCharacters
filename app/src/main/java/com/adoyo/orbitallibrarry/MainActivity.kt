package com.adoyo.orbitallibrarry

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.adoyo.orbitallibrarry.presentation.CharacterScreen
import com.adoyo.orbitallibrarry.presentation.CharacterViewModel
import com.adoyo.orbitallibrarry.ui.theme.OrbitalLibrarryTheme
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.animation.crossfade.CrossfadePlugin
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.orbital.Orbital
import com.skydoves.orbital.animateBounds
import com.skydoves.orbital.rememberMovableContentOf
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalGlideComposeApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrbitalLibrarryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewmodel = hiltViewModel<CharacterViewModel>()
                    val characters = viewmodel.characterPagingFlow.collectAsLazyPagingItems()

                    CharacterScreen(characters)
//
//                    Orbital {
//                        LazyColumn(
//                            //modifier = Modifier.fillMaxSize(),
//                        ) {
//                            items(comics.size,key = {
//                                comics[it].id
//                            }) { index ->
//                                var expanded by rememberSaveable {
//                                    mutableStateOf(false)
//                                }
//                                AnimatedVisibility(
//                                    remember {
//                                        MutableTransitionState(false)
//                                    }.apply {
//                                        targetState = true
//                                    },
//                                    enter = fadeIn()
//                                ) {
//                                    Orbital(
//                                        modifier = Modifier
//                                            .fillMaxWidth()
//                                            .clickable { expanded = !expanded }
//                                            .background(
//                                                color = comics[index].color,
//                                                shape = RoundedCornerShape(10.dp)
//                                            )
//                                    ) {
//                                        val title = rememberMovableContentOf {
//
//                                            Column(
//                                                modifier = Modifier
//                                                    .padding(10.dp)
//                                                    .animateBounds(Modifier)
//                                            ) {
//                                                Text(
//                                                    text = comics[index].title,
//                                                    fontSize = 18.sp,
//                                                    color = Color.Black,
//                                                    fontWeight = FontWeight.Bold
//                                                )
//                                                Text(
//                                                    text = comics[index].description,
//                                                    fontSize = 12.sp,
//                                                    color = Color.Gray,
//                                                    maxLines = 3,
//                                                    overflow = TextOverflow.Ellipsis,
//                                                    fontWeight = FontWeight.Bold
//                                                )
//
//                                            }
//
//                                        }
//                                        val image = rememberMovableContentOf {
//                                            com.skydoves.landscapist.glide.GlideImage(
//                                                imageModel = { comics[index].image },
//                                                component = rememberImageComponent {
//                                                    +CrossfadePlugin()
//                                                },
//                                                modifier = Modifier
//                                                    .padding(10.dp)
//                                                    .animateBounds(
//                                                        if (expanded) {
//                                                            Modifier.fillMaxWidth()
//                                                        } else {
//                                                            Modifier.size(80.dp)
//                                                        },
//                                                        spring(stiffness = Spring.StiffnessLow)
//                                                    )
//                                                    .clip(RoundedCornerShape(10.dp)),
//                                                imageOptions = ImageOptions(
//                                                    requestSize = IntSize(
//                                                        600,
//                                                        600
//                                                    )
//                                                )
//                                            )
//
//                                        }
//                                        if (expanded) {
//                                            Column {
//                                                image()
//                                                title()
//                                            }
//                                        } else {
//                                            Row {
//                                                image()
//                                                title()
//                                            }
//                                        }
//
//                                    }
//                                }
//
//
//                            }
//
//                        }
//                    }
//
                }
            }
        }
    }
}

