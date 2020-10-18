package com.ndirangu.petlover.dataloader;

import com.ndirangu.petlover.model.*;
import com.ndirangu.petlover.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final VisitService visitService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      VisitService visitService,
                      SpecialtyService specialtyService){

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.visitService = visitService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        //creating pet types
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType horse = new PetType();
        horse.setName("Horse");
        PetType savedHorsePetType = petTypeService.save(horse);

        //creating specialties
        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty kumix = new Specialty();
        kumix.setDescription("Kumix");
        Specialty savedKumix = specialtyService.save(kumix);

        //first owner with pet
        Owner mike = new Owner();
        mike.setFirstName("MIke");
        mike.setLastName("Munyotu");
        mike.setAddress("kule mtaa");
        mike.setCity("Nairobi");
        mike.setTel("1234walai");

        Pet mikesPet = new Pet();
        mikesPet.setName("Wagido");
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(mike);
        mikesPet.setBirthDate(LocalDate.now());
        mike.getPets().add(mikesPet);
        ownerService.save(mike);

        //second owner with pet
        Owner dee = new Owner();
        dee.setFirstName("Dee");
        dee.setLastName("Mathai");
        dee.setAddress("kule home");
        dee.setCity("Kiambu");
        dee.setTel("123445");

        //pet1
        Pet dees1stPet = new Pet();
        dees1stPet.setName("Kanyau");
        dees1stPet.setPetType(savedCatPetType);
        dees1stPet.setOwner(dee);
        dees1stPet.setBirthDate(LocalDate.now());

        //pet2
        Pet dees2ndPet = new Pet();
        dees2ndPet.setName("Stallion");
        dees2ndPet.setPetType(savedHorsePetType);
        dees2ndPet.setOwner(dee);
        dees2ndPet.setBirthDate(LocalDate.now());

        dee.getPets().add(dees1stPet);
        dee.getPets().add(dees2ndPet);
        ownerService.save(dee);

        //visit for second owners pet
        Visit catVisit = new Visit();
        catVisit.setPet(dees1stPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Imeletwa kuona vet");

        visitService.save(catVisit);


        //third owner with pet
        Owner senje = new Owner();
        senje.setFirstName("Susana");
        senje.setLastName("Senje");
        senje.setAddress("Majuu");
        senje.setCity("Place mob");
        senje.setTel("32444");

        Pet senjesPet = new Pet();
        senjesPet.setPetType(savedHorsePetType);
        senjesPet.setName("Farasi");
        senjesPet.setBirthDate(LocalDate.now());
        senjesPet.setOwner(senje);
        senje.getPets().add(senjesPet);
        ownerService.save(senje);

        System.out.println("LOaded owners...");

        Vet liz = new Vet();
        liz.setFirstName("liz");
        liz.setLastName("majuu");
        liz.getSpecialties().add(savedRadiology);
        vetService.save(liz);

        Vet josh = new Vet();
        josh.setFirstName("josh");
        josh.setLastName("dj");
        josh.getSpecialties().add(savedSurgery);
        josh.getSpecialties().add(savedKumix);
        josh.getSpecialties().add(savedRadiology);
        vetService.save(josh);

        System.out.println("lOaded vets...");


    }
}
