class Box<T> {
    private var top: T? = null
    private var middle: T? = null
    private var bottom: T? = null

    fun add(t: T, partition: String): Boolean {
        when (partition) {
            "Top" -> {
                if (top == null) {
                    top = t
                    return true
                }
            }

            "Middle" -> {
                if (middle == null) {
                    middle = t
                    return true
                }
            }

            "Bottom" -> {
                if (bottom == null) {
                    bottom = t
                    return true
                }
            }
        }
        return false
    }

    fun get(partition: String): T? {
        return when (partition) {
            "Top" -> top
            "Middle" -> middle
            "Bottom" -> bottom
            else -> null
        }
    }

    fun remove(partition: String) {
        when (partition) {
            "Top" -> {
                top = null
            }

            "Middle" -> {
                middle = null
            }

            "Bottom" -> {
                bottom = null
            }
        }
    }

    fun sort(comparator: Comparator<T>) {
        if (comparator.compare(middle, top) < 0) swapValues("Middle", "Top")
        if (comparator.compare(bottom, middle) < 0) swapValues("Bottom", "Middle")
        if (comparator.compare(middle, top) < 0) swapValues("Middle", "Top")
    }

    private fun swapValues(partition1: String, partition2: String) {
        val temp = get(partition1)
        update(get(partition2)!!, partition1)
        update(temp!!, partition2)
    }

    private fun update(t: T, partition: String) {
        when (partition) {
            "Top" -> {
                top = t
            }

            "Middle" -> {
                middle = t
            }

            "Bottom" -> {
                bottom = t
            }
        }
    }

    fun getAllItems(): ArrayList<T?> {
        val allItemsList = arrayListOf<T?>()

        if (top != null) {
            allItemsList.add(get("Top"))
        }
        if (middle != null) {
            allItemsList.add(get("Middle"))
        }
        if (bottom != null) {
            allItemsList.add(get("Bottom"))
        }

        return allItemsList
    }
}
