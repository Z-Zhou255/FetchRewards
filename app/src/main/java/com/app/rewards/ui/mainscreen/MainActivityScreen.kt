package com.app.rewards.ui.mainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.rewards.model.Item
import com.app.rewards.ui.theme.CardBackground
import com.app.rewards.ui.theme.TextPrimary
import com.app.rewards.ui.theme.TextSecondary
import com.app.rewards.ui.theme.GreenCircle
import com.app.rewards.viewmodel.ItemListViewModel
import com.valentinilk.shimmer.LocalShimmerTheme
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer


//This UI screen will go inside SetContent of MainActivity.

@Composable
fun MainActivityScreen(
    viewModel: ItemListViewModel
) {
    val items = viewModel.items.collectAsState().value
    val isLoading = viewModel.isLoading.collectAsState().value

    // Calling API
    LaunchedEffect(Unit) {
        viewModel.fetchRewardItems()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            // Loading state -> display shimmer effect to user
            isLoading -> {
                LazyColumn {
                    items(5) {
                        ShimmerItemRow()
                    }
                }
            }
            // When list is not empty, use LazyColumn to display items in a list
            items.isNotEmpty() -> {
                LazyColumn(Modifier.fillMaxSize()) {
                    items(items) { item ->
                        ItemRow(item = item)
                    }
                }
            }
            // When items are empty, display "Items Empty" to the user
            else -> {
                Text(
                    text = "Items Empty",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun ShimmerItemRow() {

    val shimmerBounds = ShimmerBounds.View // Example, adjust based on your needs
    val shimmerTheme = LocalShimmerTheme.current // Using the default theme

    // Create the shimmer instance with the parameters
    val shimmerInstance = rememberShimmer(
        shimmerBounds = shimmerBounds,
        theme = shimmerTheme
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(150.dp)
            .shimmer(shimmerInstance)
            .background(Color.LightGray, shape = RoundedCornerShape(12.dp))
    )
}

@Composable
fun ItemRow(item: Item) {
    Card(
        modifier = Modifier
            .fillMaxWidth().height(150.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(12.dp),
        backgroundColor = CardBackground
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(GreenCircle, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = item.listId.toString(),
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Column {
                item.name?.let {
                    Text(
                        text = it,
                        color = TextPrimary,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "List ID: ${item.listId}",
                    color = TextSecondary,
                    fontSize = 20.sp
                )
            }
        }
    }
}
