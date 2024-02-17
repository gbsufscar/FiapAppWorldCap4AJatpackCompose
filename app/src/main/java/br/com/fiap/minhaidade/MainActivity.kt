package br.com.fiap.minhaidade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.minhaidade.ui.theme.MinhaIdadeTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MinhaIdadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /// Funções
                    CounterScreen()
                }
            }
        }
    }
}

@Composable
fun CounterScreen() {

    // Variável da tela
    //var idade: Int = 21
    // Varíavel de estado
    var idade = remember {
        mutableStateOf(21)
    }


    // Criando uma coluna delimitando a tela de visualização
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Qual a sua idade?",
            fontSize = 24.sp,
            color = Color(0xFFAD1F4E),
            fontWeight = FontWeight.Bold
        )
        Text(text = "Pressione os botões para indicar a sua indade.",
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(32.dp)) // Epaçamento
        Text(fontSize = 48.sp,
            color = Color(0xFFAD1F4E),
            text = "${idade.value}", // Variável
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(32.dp)) // Epaçamento
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { idade.value-- },
                modifier = Modifier.size(84.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFAD1F4E))
            ) {
                Text(text = "-", fontSize = 40.sp)
            }
            Spacer(modifier = Modifier.width(32.dp)) // Epaçamento
            Button(onClick = { idade.value++ },
                modifier = Modifier.size(84.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFAD1F4E))
            ) {
                Text(text = "+", fontSize = 40.sp)
            }
            }
        Spacer(modifier = Modifier.height(32.dp)) // Epaçamento

        // Chamada de um Composablem dentro da CounterScreen para frase de maioridade.
        TextIdade(idade.value) // Parâmetro: valor do objeto idade
        }

    }

    // Composable com a função da frase de Mioridade
    @Composable
    fun TextIdade(idade: Int) {
        var text = ""
        text = if (idade >= 18) {
            "Você é maior de idade!"
        } else {
            "Você é menor de idade!"
        }

        Text(text = text,
            fontSize = 24.sp,
            color = Color(0xFFAD1F4E),
            fontWeight = FontWeight.Bold
        )
    }

    // Permitir a visualização da aplicação enquanto se promove as mudanças no código
    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun CounterScreenPreview() {
        CounterScreen() // Para renderizar o componente que acabou de ser criado.
    }
