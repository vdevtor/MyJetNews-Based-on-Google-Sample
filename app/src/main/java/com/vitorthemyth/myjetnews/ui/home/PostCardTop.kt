package com.vitorthemyth.myjetnews.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vitorthemyth.myjetnews.R
import com.vitorthemyth.myjetnews.data.posts.imp.posts
import com.vitorthemyth.myjetnews.model.Post
import com.vitorthemyth.myjetnews.ui.theme.MyJetNewsTheme
import com.vitorthemyth.myjetnews.utils.CompletePreviews

@Composable
fun PostCardTop(post: Post, modifier: Modifier = Modifier) {
    // TUTORIAL CONTENT STARTS HERE
    val typography = MaterialTheme.typography
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        val imageModifier = Modifier
            .heightIn(min = 180.dp)
            .fillMaxWidth()
            .clip(shape = MaterialTheme.shapes.medium)
        Image(
            painter = painterResource(post.imageId),
            contentDescription = null, // decorative
            modifier = imageModifier,
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(16.dp))

        Text(
            text = post.title,
            style = typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = post.metadata.author.name,
            style = typography.labelLarge,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = stringResource(
                id = R.string.home_post_min_read,
                formatArgs = arrayOf(
                    post.metadata.date,
                    post.metadata.readTimeMinutes
                )
            ),
            style = typography.bodySmall
        )
    }
}
// TUTORIAL CONTENT ENDS HERE

/**
 * Preview of the [PostCardTop] composable. Fake data is passed into the composable.
 *
 * Learn more about Preview features in the [documentation](https://d.android.com/jetpack/compose/tooling#preview)
 */
@Preview
@Composable
fun PostCardTopPreview() {
    MyJetNewsTheme {
        Surface {
            PostCardTop(posts.highlightedPost)
        }
    }
}

/*
 * These previews will only show up on Android Studio Dolphin and later.
 * They showcase a feature called Multipreview Annotations.
 *
 * Read more in the [documentation](https://d.android.com/jetpack/compose/tooling#preview-multipreview)
*/
@CompletePreviews
@Composable
fun PostCardTopPreviews() {
    MyJetNewsTheme {
        Surface {
            PostCardTop(posts.highlightedPost)
        }
    }
}
