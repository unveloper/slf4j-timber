package com.spiral_root.android.test_app.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.spiral_root.android.test_app.ui.theme.TestAppTheme
import com.spiral_root.android.test_app.utils.collectAsStateLifecycleAware
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			TestAppTheme {
				// A surface container using the 'background' color from the theme
				Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
					Home("Android")
				}
			}
		}
	}
}

@Composable
fun Home(
	name: String,
	onClick: () -> Unit, lastActionTime: LocalDateTime?,
	modifier: Modifier = Modifier
) {
	ConstraintLayout(
		modifier = modifier
			.fillMaxWidth()
	) {
		val (titleRef, buttonRef, lastActionTimeRef) = createRefs()
		Text(
			modifier = Modifier
				.constrainAs(titleRef) {
					top.linkTo(parent.top, margin = 15.dp)
					start.linkTo(parent.start)
					end.linkTo(parent.end)
					centerHorizontallyTo(parent)
				},
			text = "Hello $name!"
		)
		TextButton(
			modifier = Modifier
				.constrainAs(buttonRef) {
					top.linkTo(titleRef.bottom, margin = 15.dp)
					start.linkTo(parent.start)
					end.linkTo(parent.end)
					centerHorizontallyTo(parent)
				},
			onClick = onClick
		) {
			Text(text = "Click me :)")
		}
		val lastActionValue = if (lastActionTime == null) "---" else DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(lastActionTime)
		Text(
			modifier = Modifier
				.constrainAs(lastActionTimeRef) {
					top.linkTo(buttonRef.bottom, margin = 5.dp)
					start.linkTo(parent.start)
					end.linkTo(parent.end)
					centerHorizontallyTo(parent)
				},
			text = "Last action time: $lastActionValue"
		)
	}
}

@Composable
fun Home(name: String, viewModel: MainViewModel = hiltViewModel()) {
	val lastActionTime = viewModel.lastActionTime.collectAsStateLifecycleAware()
	Home(
		name = name,
		onClick = { viewModel.doAction() }, lastActionTime = lastActionTime.value
	)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	TestAppTheme {
		Home(
			"Android",
			{}, LocalDateTime.of(2022, 8, 29, 10, 30, 0, 0)
		)
	}
}