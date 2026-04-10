package vagasws;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estudante {
    private long id;
    private String nome;
    private String cpf;
    private double pretensaoSalarial;
}