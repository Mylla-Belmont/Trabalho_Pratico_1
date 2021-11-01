import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class Pokemon {
    @CsvBindByName(column = "Nome")
    @CsvBindByPosition(position = 0)
    private final String nome;

    @CsvBindByName(column = "Tipo")
    @CsvBindByPosition(position = 1)
    private final String tipo;

    @CsvBindByName(column = "Ataque")
    @CsvBindByPosition(position = 2)
    private final int ataque;

    @CsvBindByName(column = "Dano")
    @CsvBindByPosition(position = 3)
    private final int dano;

    @CsvBindByName(column = "Resistencia")
    @CsvBindByPosition(position = 4)
    private final int resistencia;

    public Pokemon(String nome, String tipo, int ataque, int dano, int resistencia) {
        this.nome = nome;
        this.tipo = tipo;
        this.ataque = ataque;
        this.dano = dano;
        this.resistencia = resistencia;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDano() {
        return dano;
    }

    public int getResistencia() {
        return resistencia;
    }

    @Override
    public String toString() {
        return  "\"" + this.nome + "\"" + "," +
                "\"" + this.tipo + "\"" + "," +
                "\"" + this.ataque + "\"" + "," +
                "\"" + this.dano + "\"" + "," +
                "\"" + this.resistencia + "\"" + "\n";
    }
}
