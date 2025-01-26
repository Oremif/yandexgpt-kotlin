package org.oremif.yandexml.models.responses

import org.oremif.yandexml.models.data.Token
import kotlinx.serialization.Serializable

/***
 * Response containing tokenized content from the request.
 *
 * @property tokens A list of tokens obtained from tokenization.
 * @property modelVersion Model version (changes with model releases).
 */
@Serializable
public data class TokenizeResponse(
    val tokens: List<Token>,
    val modelVersion: String
)