package com.todo.todocalendar.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kizitonwose.calendar.core.CalendarDay
import com.kizitonwose.calendar.core.DayPosition

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Day(day: CalendarDay, isSelected: Boolean, onClick: (CalendarDay) -> Unit) {

    OutlinedCard(
        modifier = Modifier
            .aspectRatio(0.9f)
            .padding(3.dp),
        enabled = day.position == DayPosition.MonthDate,
        onClick = { onClick(day) },
        colors = CardDefaults.cardColors(
            containerColor =
            if (isSelected)
                MaterialTheme.colorScheme.primary
            else
                Color.Transparent
        )
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(vertical = 10.dp),
                text = day.date.dayOfMonth.toString(),
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}