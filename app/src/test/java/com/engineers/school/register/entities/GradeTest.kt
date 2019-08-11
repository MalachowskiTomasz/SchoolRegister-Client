package com.engineers.school.register.entities

import kotlinx.serialization.json.Json
import org.assertj.core.api.Assertions.assertThat
import org.joda.time.DateTime
import org.junit.Test

class GradeTest {

    private val dateTime = DateTime(2019, 12, 12, 12, 12)
    private val mark = 5.5F

    @Test
    fun shouldSerializeGradeToJson() {
        val grade = Grade(mark, dateTime)

        val serializedGrade = Json.stringify(Grade.serializer(), grade)

        assertThat(serializedGrade).isEqualTo("""{"mark":5.5,"date":"12-12-2019 12:12"}""")
    }

    @Test
    fun shouldDeserializeGradeFromJson() {
        val gradeJson = """{"mark":5.5,"date":"12-12-2019 12:12"}"""

        val grade = Json.parse(Grade.serializer(), gradeJson)

        assertThat(grade.date).isEqualTo(dateTime)
        assertThat(grade.mark).isEqualTo(mark)
    }

    @Test
    fun shouldDeserializeGradeFromJson_whenOrderIsChanged() {
        val gradeJson = """{"date":"12-12-2019 12:12","mark":5.5}"""

        val grade = Json.parse(Grade.serializer(), gradeJson)

        assertThat(grade.date).isEqualTo(dateTime)
        assertThat(grade.mark).isEqualTo(mark)
    }
}