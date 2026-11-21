package com.example.learningnewconepts.Screens
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.SearchBarDefaults.inputFieldColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.ModifierLocalReadScope
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learningnewconepts.ViewModels.TestingScreenViewModel

import java.nio.file.WatchEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestingScreen(viewModel: TestingScreenViewModel = viewModel()) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column (modifier = Modifier.fillMaxSize()
            .padding(16.dp)) {
            SearchBar(
                inputField = {
                    SearchBarDefaults.InputField(
                        query = viewModel.text_to_display,
                        onQueryChange = {
                            viewModel.changetext(it)
                            viewModel.applyfilters(it)
                        },
                        onSearch = {
                            viewModel.applyfilters(it)
                            viewModel.changeenabled(false)
                        },
                        expanded = viewModel.issearchbarenabled,
                        placeholder = {
                            Text(text = "Search")
                        },
                        trailingIcon = {
                            IconButton(onClick = {
                                if (viewModel.text_to_display.isNotEmpty()) {
                                    viewModel.changetext("")
                                    viewModel.applyfilters("")
                                } else {
                                    viewModel.changeenabled(false)
                                }
                            }) {
                                Icon(imageVector = Icons.Default.Cancel, null)
                            }
                        },
                        onExpandedChange = {
                            viewModel.changeenabled(it)
                        }
                    )
                },
                expanded = viewModel.issearchbarenabled,
                onExpandedChange = {
                    viewModel.changeenabled(it)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = SearchBarColors(
                    containerColor = Color.White,
                    dividerColor = Color.Red,
                    inputFieldColors =SearchBarDefaults.inputFieldColors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.DarkGray,
                        cursorColor = Color.Red,
                        focusedPlaceholderColor = Color.Gray,
                        unfocusedPlaceholderColor = Color.Gray,
                        focusedTrailingIconColor = Color.Black,
                        unfocusedTrailingIconColor = Color.Gray
                    )
                )
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    if (viewModel.itemstodiplay.isEmpty()) {
                        item {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text("No Search Match")
                            }
                        }
                    } else {
                        items(viewModel.itemstodiplay) { name ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(16.dp))
                                    .background(Color.Red.copy(alpha = 0.2f))
                                    .clickable(onClick = {
                                        viewModel.changetext(name)
                                        viewModel.applyfilters(name)
                                        viewModel.changeenabled(false)
                                    })
                                    .padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(imageVector = Icons.Default.Android,null)
                                Spacer(modifier = Modifier.width(3.dp))
                                Text(name)
                            }
                        }
                    }

                }
            }
        }
    }
}