package vagasws;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vaga {
    private long id;
    private String cargo;
    private double salario;
    private String cidade;
}