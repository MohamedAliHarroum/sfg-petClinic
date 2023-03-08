package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0 ){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("salah");
        owner1.setLastName("mohamed ");
        owner1.setAddress(" 4000 sousse");
        owner1.setCity("sousse");
        owner1.setTelephone("+216222222222");

        Pet salhsPet = new Pet();
        salhsPet.setPetType(savedDogPetType);
        salhsPet.setOwner(owner1);
        salhsPet.setBirthDate(LocalDate.now());
        salhsPet.setName("Rosco");
        owner1.getPets().add(salhsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("ali");
        owner2.setLastName("ben mohamed");
        owner2.setAddress("4000 sousse");
        owner2.setCity("sousse");
        owner2.setTelephone("+21622222222");

        Pet alisCat = new Pet();
        alisCat.setName("Just Cat");
        alisCat.setOwner(owner2);
        alisCat.setBirthDate(LocalDate.now());
        alisCat.setPetType(savedCatPetType);
        owner2.getPets().add(alisCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(alisCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("nour");
        vet2.setLastName("ali");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}