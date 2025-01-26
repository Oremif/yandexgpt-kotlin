package org.oremif.yandexml.models.data

import kotlinx.serialization.Serializable

/**
 * Represents a token, the basic unit of content, used by the foundation model.
 *
 * @property id String (int64) — An internal token identifier.
 * @property text The textual representation of the token.
 * @property special Indicates whether the token is special or not. Special tokens may define the model's behavior and are not visible to users.
 */
@Serializable
public data class Token(
    val id: String,
    val text: String,
    val special: Boolean
)