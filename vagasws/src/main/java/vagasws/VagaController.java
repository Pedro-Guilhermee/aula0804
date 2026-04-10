package vagasws;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
public class VagaController {

    private List<Vaga> vagas = new ArrayList<>();

    public VagaController() {
        vagas.add(new Vaga(1, "Desenvolvedor Java Jr", 4500.0, "São Paulo"));
    }

    @GetMapping("fci/api/vagas")
    public Iterable<Vaga> getVagas() {
        return vagas;
    }

    @GetMapping("/fci/api/vagas/{id}")
    public Vaga getVaga(@PathVariable long id) {
        for (Vaga v : vagas) {
            if (v.getId() == id) return v;
        }
        return null;
    }

    @PostMapping("fci/api/vagas")
    public Vaga createVaga(@RequestBody Vaga novaVaga) {
        long novoId = vagas.isEmpty() ? 1 : vagas.get(vagas.size() - 1).getId() + 1;
        novaVaga.setId(novoId);
        vagas.add(novaVaga);
        return novaVaga;
    }

    @PutMapping("/fci/api/vagas/{id}")
    public Vaga updateVaga(@PathVariable long id, @RequestBody Vaga dadosAtualizados) {
        for (Vaga v : vagas) {
            if (v.getId() == id) {
                v.setCargo(dadosAtualizados.getCargo());
                v.setSalario(dadosAtualizados.getSalario());
                v.setCidade(dadosAtualizados.getCidade());
                return v;
            }
        }
        return null;
    }

    @DeleteMapping("/fci/api/vagas/{id}")
    public void deleteVaga(@PathVariable long id) {
        vagas.removeIf(v -> v.getId() == id);
    }
}
