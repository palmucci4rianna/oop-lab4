# Improving an existing design with inheritance

Look at `SimpleBankAccount` and `StrictBankAccount`.

1. Create a new class `ExtendedStrictBankAccount` that extends `SimpleBankAccount`,
  with the same behavior of `StrictBankAccount` (provided by us).
  Your goal is to reduce, as much as possible, code duplications.
  *Note:* modifying `BankAccount`, `AccountHolder`, or `SimpleBankAccount` is *forbidden*.

2. Change the type of the class created in `TestBankAccount` and use it to test your implementation

3. Analyse what you just did: compare your `ExtendedStrictBankAccount` with `StrictBankAccount`. See how much code you *reused*.

4. Answer the following question: *How would you have designed the application, if you knew interfaces and and inheritance?*
  interfaccia account per i metodi
  simple implementa account 
  strict estende simple

    * Originally, we used inheritance in order to improve a sub-optimal design (of course it was sub-optimal, we didn't know inheritance existed!). 
    * Provide a simple UML scheme (draw it on paper or on [mermaid.live](https://mermaid.live/edit#pako:eNptkctOAzEMRX8l8gpE5weibhClEouuuqsiIU_iTqPJA_JQBWX-nUxgpNDilXVu7pXtXEB6RcBBGoxxo3EIaIVjpR6dtmjY-qvr2CbL8ZZudTzd0gP1Af9gzh60SwwHusb7FLQb2EBOUWjF2RJ3aEt7d38lWEy0wDp2He_yA-ZaYnvC8ckbHxopnrVdzBW8Z5TjQqY2dV6vSe3mHaL-pBe3JUqNINE9Y_o3ox6jHa333jAdX8_aqAaH7Bo_rMBSsKhV-ZnqFpBOZEkAL62iI2aTBAg3laeYk99_OAk8hUwryG-qXOj3L4Ef0USavgH6HZMp)) with your design proposal and let the teacher see it.
    * Draw the *vtable (virtual method table)* of the classes in your hierarchy.

java -cp bin/main it.unibo.inheritance.test.TestBankAccount

classDiagram
    Account <|.. SimpleBankAccount
    SimpleBankAccount <|-- StrictBankAccount
    class Account {
        <<interface>>
        +deposit(amount)
        +withdraw(amount)
        +getBalance()
    }
    class SimpleBankAccount{
        -balance: double
        +deposit(amount)
        +withdraw(amount)
        +getBalance()
    }
    class StrictBankAccount{
        +withdraw(amount)
    }
https://mermaid.live/edit#pako:eNq1UclugzAQ_RU0p1QliCVsVhSpyx_kVnFx7Amxgm1kjNKU8u8FsjRqKvXUOXneMvM07oBpjkCAVbRpXgUtDZWFcoZ6Yky3yjrLT89z1kLWFT5TtT_DJ80dPKjnc2dtjWD2Tj3tuM7tTuBYy6VQFs2WMlytvuFHjrVuhJ1ROToebpiDsDtu6OEXqsRhc0UVw9kZ7m_X30W-yTHfnIzE4brdVPjfUX6eqftzbA8ulEZwINa06IJEI-nYwuQtwO5QYgFkeHJq9gUUavTUVL1pLS82o9tyd2namlOL578HsqVVM6C0tXp9VOxqQcXRvIxZgIRJPs0E0sE7kCDOvCBPoyRaZLkfR3HqwhFInnt5GKRJFKRh4gd-1LvwMaXwvSQOs8hfhFE2MFn_BbX_yJA

vtable:
Class 	          deposit()	withdraw()	getBalance()
SimpleBankAccount	✔️	      ✔️	         ✔️
StrictBankAccount	✔️	      override	   ✔️
- deposit() e getBalance() sono ereditati direttamente.
- withdraw() è sovrascritto per aggiungere vincoli.