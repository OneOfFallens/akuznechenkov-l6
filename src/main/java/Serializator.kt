import java.io.*

class Serializator() {
    fun serialize(o: Any): ByteArray{
        val output = ByteArrayOutputStream()
        val objectOutput = ObjectOutputStream(output)
        objectOutput.writeObject(o)
        return output.toByteArray()
    }

    fun deserialize(b: ByteArray): Any? {
        try {
            var o: Any? = null
            val input = ByteArrayInputStream(b)
            val objectInput = ObjectInputStream(input)
            o = objectInput.readObject()
          //  println("Получен объект")
            return if ((o is DataStor) || (o is ServerMessage) || (o is LoginRequest) || (o is LoginAnswer)) {
                o
            } else {
                println("Был получен не тот объект")
                null
            }
       }
       catch(e: StreamCorruptedException){
            return null
        }
    }
}