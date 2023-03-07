package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }




    @Override
    public void run(String... args) throws Exception {

        //Creating and saving owner1
        Owner owner1 = new Owner();


        owner1.setFirstName("mohamed");
        owner1.setLastName("salah");

        ownerService.save(owner1);

        //Creating and saving owner2
        Owner owner2 = new Owner();


        owner2.setFirstName("aziz");
        owner2.setLastName("ali");

        ownerService.save(owner2);

        System.out.println("Loaded Owners ....");

        //Creating and saving Vet1
        Vet vet1 = new Vet();

        vet1.setFirstName("san");
        vet1.setLastName("axe");

        vetService.save(vet1);

        //Creating and saving Vet2
        Vet vet2 = new Vet();


        vet2.setFirstName("san");
        vet2.setLastName("axe");

        vetService.save(vet2);

        System.out.println("Loaded Vets ....");


    }
}