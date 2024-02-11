package com.todo.todocalendar.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.todo.todocalendar.presentation.components.Day
import com.todo.todocalendar.presentation.components.DaysOfWeekTitle
import com.todo.todocalendar.presentation.components.SheetContent
import com.kizitonwose.calendar.compose.HorizontalCalendar
import com.kizitonwose.calendar.compose.rememberCalendarState
import com.kizitonwose.calendar.core.daysOfWeek
import com.kizitonwose.calendar.core.firstDayOfWeekFromLocale
import org.koin.androidx.compose.koinViewModel
import java.time.YearMonth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoScreen(viewModel: TodoViewModel = koinViewModel()) {

    val currentMonth = remember { YearMonth.now() }
    val startMonth = remember { currentMonth.minusMonths(12) }
    val endMonth = remember { currentMonth.plusMonths(12) }
    val firstDayOfWeek = remember { firstDayOfWeekFromLocale() }
    val daysOfWeek = daysOfWeek(firstDayOfWeek = firstDayOfWeek)

    val calendarState = rememberCalendarState(
        startMonth = startMonth,
        endMonth = endMonth,
        firstVisibleMonth = currentMonth,
        firstDayOfWeek = firstDayOfWeek
    )

    val state by viewModel.state.collectAsState()

    LaunchedEffect(true) {
        viewModel.getTasks(state.selectedDate)
    }

    BottomSheetScaffold(
        sheetContent = { SheetContent() }
    ) {
        HorizontalCalendar(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            state = calendarState,
            dayContent = {
                Day(day = it, isSelected = state.selectedDate == it.date) { day ->
                    viewModel.getTasks(day.date)
                }
            },
            monthHeader = {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = it.yearMonth.month.name,
                    style = MaterialTheme.typography.headlineSmall
                )
                DaysOfWeekTitle(daysOfWeek = daysOfWeek)
            },
            monthFooter = { Divider(modifier = Modifier.padding(10.dp)) }
        )
    }
}

