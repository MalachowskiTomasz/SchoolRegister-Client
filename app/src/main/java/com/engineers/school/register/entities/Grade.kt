package com.engineers.school.register.entities

import kotlinx.serialization.*
import kotlinx.serialization.internal.SerialClassDescImpl
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter

@Serializable
data class Grade(val mark: Float, val date: DateTime) {
    @Serializer(forClass = Grade::class)
    companion object : KSerializer<Grade> {
        private val datetimeFormatter: DateTimeFormatter = DateTimeFormat.forPattern("dd-MM-yyyy H:m")

        override val descriptor: SerialDescriptor = object : SerialClassDescImpl("Grade") {
            init {
                addElement("mark")
                addElement("date")
            }
        }

        override fun serialize(encoder: Encoder, obj: Grade) {
            val compositeOutput = encoder.beginStructure(descriptor)
            compositeOutput.encodeFloatElement(descriptor, 0, obj.mark)
            compositeOutput.encodeStringElement(descriptor, 1, datetimeFormatter.print(obj.date))
            return compositeOutput.endStructure(descriptor)
        }

        override fun deserialize(decoder: Decoder): Grade {
            val dec = decoder.beginStructure(descriptor)
            var mark: Float? = null
            var date: DateTime? = null
            loop@while (true) {
                when (val i = dec.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> mark = dec.decodeFloatElement(descriptor, i)
                    1 -> date = datetimeFormatter.parseDateTime(dec.decodeStringElement(descriptor, i))
                }
            }
            dec.endStructure(descriptor)

            return Grade(mark!!, date!!)
        }
    }
}