package vagasws;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
public class EstudanteController {

    private List<Estudante> estudantes = new ArrayList<>();

    public EstudanteController() {
        estudantes.add(new Estudante(1, "João Silva", "123.456.789-00", 5000.0));
    }

    @GetMapping("fci/api/estudantes")
    public Iterable<Estudante> getEstudantes() {
        return estudantes;
    }

    @GetMapping("/fci/api/estudantes/{id}")
    public Estudante getEstudante(@PathVariable long id) {
        for (Estudante c : estudantes) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    @PostMapping("fci/api/estudantes")
    public Estudante createEstudante(@RequestBody Estudante novo) {
        long novoId = estudantes.isEmpty() ? 1 : estudantes.get(estudantes.size() - 1).getId() + 1;
        novo.setId(novoId);
        estudantes.add(novo);
        return novo;
    }

    @PutMapping("/fci/api/estudantes/{id}")
    public Estudante updateEstudante(@PathVariable long id, @RequestBody Estudante dados) {
        for (Estudante c : estudantes) {
            if (c.getId() == id) {
                c.setNome(dados.getNome());
                c.setCpf(dados.getCpf());
                c.setPretensaoSalarial(dados.getPretensaoSalarial());
                return c;
            }
        }
        return null;
    }

    @DeleteMapping("/fci/api/estudantes/{id}")
    public void deleteEstudante(@PathVariable long id) {
        estudantes.removeIf(c -> c.getId() == id);
    }
}