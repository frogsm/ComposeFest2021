package com.example.compose.rally

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/*
아래 에러로 인해 테스트 결과 확인하지 못해 봄.
안드 12 타겟이면, 메니페스트에서 액티비티 쪽에 exported true 로 설정 해줘야한다는 내용

액티비티에 exported 설정되어있음에도 불구하고, 에러 발생 중..

ref. https://stackoverflow.com/questions/69713976/how-to-overcome-this-build-error-when-trying-to-run-jetpack-compose-instrumentat

/Users/frogsm/Documents/cloud-android/ComposeFest2021/week 3-3-Jetpack Compose Navigation/app/build/intermediates/tmp/manifest/androidTest/debug/tempFile1ProcessTestManifest3300074324865873844.xml Error:
	android:exported needs to be explicitly specified for <activity>. Apps targeting Android 12 and higher are required to specify an explicit value for `android:exported` when the corresponding component has an intent filter defined. See https://developer.android.com/guide/topics/manifest/activity-element#exported for details.
/Users/frogsm/Documents/cloud-android/ComposeFest2021/week 3-3-Jetpack Compose Navigation/app/build/intermediates/tmp/manifest/androidTest/debug/tempFile1ProcessTestManifest3300074324865873844.xml Error:
	android:exported needs to be explicitly specified for <activity>. Apps targeting Android 12 and higher are required to specify an explicit value for `android:exported` when the corresponding component has an intent filter defined. See https://developer.android.com/guide/topics/manifest/activity-element#exported for details.
/Users/frogsm/Documents/cloud-android/ComposeFest2021/week 3-3-Jetpack Compose Navigation/app/build/intermediates/tmp/manifest/androidTest/debug/tempFile1ProcessTestManifest3300074324865873844.xml Error:
	android:exported needs to be explicitly specified for <activity>. Apps targeting Android 12 and higher are required to specify an explicit value for `android:exported` when the corresponding component has an intent filter defined. See https://developer.android.com/guide/topics/manifest/activity-element#exported for details.

See http://g.co/androidstudio/manifest-merger for more information about the manifest merger.


Execution failed for task ':app:processDebugAndroidTestManifest'.
> Manifest merger failed with multiple errors, see logs

 */
class RallyNavHostTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    lateinit var navController: NavHostController

    @Before
    fun setupRallyNavHost() {
        composeTestRule.setContent {
            navController = rememberNavController()
            RallyNavHost(navController = navController)
        }
    }

    @Test
    fun rallyNavHost() {
        composeTestRule
            .onNodeWithContentDescription("Overview Screen")
            .assertIsDisplayed()
    }

    @Test
    fun rallyNavHost_navigateToBills_viaUI() {
        // When click on "All Bills"
        composeTestRule.onNodeWithContentDescription("All Bills").apply {
            performScrollTo()
            performClick()
        }
        // Then the route is "Bills"
        val route = navController.currentBackStackEntry?.destination?.route
        assertEquals(route, "Bills")
    }

    @Test
    fun rallyNavHost_navigateToAllAccounts_callingNavigate() {
        runBlocking {
            withContext(Dispatchers.Main) {
                navController.navigate(RallyScreen.Accounts.name)
            }
        }
        composeTestRule
            .onNodeWithContentDescription("Accounts Screen")
            .assertIsDisplayed()
    }
}