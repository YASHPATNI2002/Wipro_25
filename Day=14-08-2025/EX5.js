// Base class
class Vehicle {
    constructor(make, model, year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    getInfo() {
        return `${this.year} ${this.make} ${this.model}`;
    }
}

// Subclass extending Vehicle
class Car extends Vehicle {
    constructor(make, model, year, numDoors) {
        super(make, model, year); // Call parent constructor
        this.numDoors = numDoors;
    }

    // Override getInfo
    getInfo() {
        return `${super.getInfo()} - ${this.numDoors} doors`;
    }
}

// Demo
let vehicle1 = new Vehicle("Toyota", "Corolla", 2020);
console.log(vehicle1.getInfo()); // 2020 Toyota Corolla

let car1 = new Car("Honda", "Civic", 2022, 4);
console.log(car1.getInfo()); // 2022 Honda Civic - 4 doors
