package org.matt.restmongo.restfulmongo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FootballerAPI {
    private final FootballerRepo repo;

    public FootballerAPI(FootballerRepo repo) {
        this.repo = repo;
    }


    @GetMapping("/players")
    List<Footballer> showAll() {
        return repo.findAll();
    }

    @PostMapping("/players")
    Footballer newPlayer(@RequestBody Footballer newPlayer) {
        return repo.save(newPlayer);
    }

    @GetMapping("/players/{shitNumber}")
    Footballer getOne(@PathVariable int shitNumber) {
        Footballer one = repo.getByShirtNumber(shitNumber);
        if (one != null) {
            return one;
        } else {
            throw new PlayerNotFoundException(shitNumber);
        }
    }

    /*@GetMapping("players/list/{position}")
    List<Footballer> getListByPos(@PathVariable String position) {
        return repo.getByPosition(position);
    }*/

    @GetMapping("/players/list")
    List<Footballer> getListByPos(@RequestParam(value = "pos", /*defaultValue = "GK",*/ required = false) String position,
                                  @RequestParam(value = "name", required = false) String name) {
        if (position != null) {
            return repo.getByPosition(position);
        } else if (name != null) {
            return repo.getByFirstName(name);
        }

        return null;

    }


    @PutMapping("/players/{shitNumber}")
    Footballer updatePlayer(@RequestBody Footballer updatedPlayer, @PathVariable int shitNumber) {

        Footballer oldInfo =  repo.getByShirtNumber(shitNumber);
        if (oldInfo != null) {
            oldInfo.setFirstName(updatedPlayer.getFirstName());
            oldInfo.setLastName(updatedPlayer.getLastName());
            oldInfo.setPosition(updatedPlayer.getPosition());
            oldInfo.setPrice(updatedPlayer.getPrice());
            return repo.save(oldInfo);
        } else {
            updatedPlayer.setShirtNumber(shitNumber);
            return repo.save(updatedPlayer);
        }
    }

    @DeleteMapping("/players/{id}")
    void deletePlayer(@PathVariable int id) {
        repo.deleteByShirtNumber(id);
    }
}
