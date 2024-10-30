package io.github.oremif.yandexgpt

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline


/**
 * Represents a list of tool calls.
 * @property toolCalls A list of tool calls to be executed.
 */
@Serializable
@JvmInline
public value class ToolCallList(val toolCalls: List<YaGptToolCall>)

/**
 * Represents a call to a tool.
 * @property functionCall Represents a call to a function.
 *
 * Includes only one of the fields `functionCall`.
 */
@Serializable
@JvmInline
public value class YaGptToolCall(val functionCall: YaFunctionCall)

/**
 * Represents the invocation of a function with specific arguments.
 *
 * @property name The name of the function being called.
 * @property arguments The structured arguments passed to the function.
 * These arguments must adhere to the JSON Schema defined in the corresponding function's parameters.
 */
@Serializable
public data class YaFunctionCall(
    val name: String,
    val arguments: Map<String, String> = emptyMap()
)

/**
 * Represents a list of tool results.
 * @property toolResults A list of tool results.
 */
@Serializable
@JvmInline
public value class ToolResultList(val toolResults: List<YaGptToolResult>)

/**
 * Represents the result of a tool call.
 * @property functionResult Represents the result of a function call.
 *
 * Includes only one of the fields `functionResult`.
 */
@Serializable
@JvmInline
public value class YaGptToolResult(val functionResult: YaFunctionResult)

/**
 * Represents the result of a function call.
 *
 * @property name The name of the function that was executed.
 * @property content The result of the function call, represented as a string.
 * This field can be used to store the output of the function.
 *
 * Includes only one of the fields `content`.
 */
@Serializable
public data class YaFunctionResult(
    val name: String,
    val content: String
)

/**
 * Represents a tool that can be invoked during completion generation.
 * @property function Represents a function that can be called.
 *
 * Includes only one of the fields `function`.
 */
@Serializable
@JvmInline
public value class YaGptTool(val function: YaGptFunctionTool)

/**
 * Represents a function tool that can be invoked during completion generation.
 *
 * @property name The name of the function.
 * @property description A description of the function's purpose or behavior.
 * @property parameters A JSON Schema that defines the expected parameters for the function.
 * The schema should describe the required fields, their types, and any constraints or default values.
 */
@Serializable
public data class YaGptFunctionTool(
    val name: String,
    val description: String,
    val parameters: Map<String, String> = emptyMap()
)