package info.justinthought.example.common.row

data class ExampleRow(val title: String, val subtitle: String, val detail: String) {
    companion object {
        val placeholder: ExampleRow
            get() = ExampleRow(
                "Placeholder",
                "Placeholder",
                "Placeholder"
            )

        val data: List<ExampleRow>
            get() = listOf(
                ExampleRow(
                    "Alpha",
                    "a as in English father, but short",
                    "α"
                ),
                ExampleRow(
                    "Beta",
                    "v as in English vote",
                    "β"
                ),
                ExampleRow(
                    "Gamma",
                    "g as in Spanish lago or y as in English yellow, ng as in English long",
                    "γ"
                )
            )
    }
}
