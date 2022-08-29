package com.spiral_root.android.test_app

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
import androidx.constraintlayout.compose.Dimension
import com.spiral_root.android.test_app.ui.theme.TestAppTheme
import dagger.hilt.android.AndroidEntryPoint

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
fun Home(name: String, modifier: Modifier = Modifier) {
	ConstraintLayout(
		modifier = modifier
			.fillMaxWidth()
	) {
		val (titleRef, buttonRef) = createRefs()
		Text(
			modifier = Modifier
				.constrainAs(titleRef) {
					top.linkTo(parent.top, margin = 15.dp)
					start.linkTo(parent.start)
					end.linkTo(parent.end)
					width = Dimension.fillToConstraints
				},
			text = "Hello $name!"
		)
		TextButton(
			modifier = Modifier
				.constrainAs(buttonRef) {
					top.linkTo(titleRef.bottom, margin = 15.dp)
					start.linkTo(parent.start)
					end.linkTo(parent.end)
				},
			onClick = { /*TODO*/ }) {
			Text(text = "Click me :)")
		}
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	TestAppTheme {
		Home("Android")
	}
}