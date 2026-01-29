package views

import services.ITodoService
import utils.InputUtil

class TodoView(private val todoService: ITodoService) {

    fun showTodos() {
        while (true) {
            todoService.showTodos()

            println("\nMenu:")
            println("1. Tambah")
            println("2. Ubah")
            println("3. Cari")
            println("4. Urutkan")
            println("5. Hapus")
            println("x. Keluar")

            when (InputUtil.input("Pilih")) {
                "1" -> addTodo()
                "2" -> updateTodo()
                "3" -> searchTodo()
                "4" -> sortTodo()
                "5" -> removeTodo()
                "x" -> break
                else -> println("[!] Pilihan tidak dimengerti.")
            }
            println()
        }
    }

    fun addTodo() {
        val title = InputUtil.input("Judul (x jika batal)")
        if (title != "x") {
            todoService.addTodo(title)
        }
    }

    fun removeTodo() {
        val id = InputUtil.input("ID Todo (x jika batal)")
        if (id != "x") {
            todoService.removeTodo(id.toInt())
        }
    }

    fun updateTodo() {
        println("[Ubah Todo]")
        val id = InputUtil.input("ID Todo")
        val newTitle = InputUtil.input("Judul Baru")

        todoService.updateTodo(id.toInt(), newTitle)
    }

    fun searchTodo() {
        println("[Cari Todo]")
        val keyword = InputUtil.input("Kata Kunci")
        todoService.searchTodo(keyword)
    }

    fun sortTodo() {
        println("[Urutkan Todo]")
        todoService.sortTodo()
    }
}
