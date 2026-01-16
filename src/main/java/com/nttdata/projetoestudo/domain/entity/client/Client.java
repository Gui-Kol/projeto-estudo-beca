package com.nttdata.projetoestudo.domain.entity.client;

public class Client {
    private Long id;
    private String name;
    private String email;
    private int cpf;

    public Client(Long id, String name, String email, int cpf) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }
    public Client(String name, String email, int cpf) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return  "id= " + id +
                "\nname= " + name +
                "\nemail= " + email +
                "\ncpf= " + cpf;
    }
}
