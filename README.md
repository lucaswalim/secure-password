<h2>
  Senha Segura
</h2>

Resolução do desafio proposto pelo repositorio Backend Brasil, para fins de estudo, repasses e consultas futuras.

## :rocket: Tecnologias utilizadas
* Java
* Spring Boot

## 🧩 Design Patterns
* Strategy
* Chain of Responsability
* ...

## Proposta do Desafio

Implementar um serviço que valide se uma senha é considerada segura com base em critérios pré-definidos

## Como usar ?

Seu serviço recebe uma chamada para validar uma senha.

**[POST]** `{{host}}/api/password/strategy-validate`

```json
{
    "password": "vYQIYxO&p$yfI^r1"
}
```

Se a senha atender a todos os critérios de segurança, deverá retornar uma resposta de sucesso.

```
HTTP/1.1 200 Sucess
```
```json
{
    "valid": true,
    "messages": []
}
```

Caso contrário, deverá retornar uma mensagem informando quais critérios não foram atendidos.
```
HTTP/1.1 400 Bad Request
```

```json
{
    "valid": false,
    "messages": [
        "A senha deve possuir pelo menos 8 caracteres",
        "A senha deve possuir pelo menos 1 caractere MAIÚSCULO",
        "A senha deve possuir pelo menos 1 caractere MINÙSUCLO",
        "A senha deve possuir pelo menos 1 caractere ESPECIAL"
    ]
}
```

## Validações Realizadas

- Verificar se a senha possui pelo menos 08 caracteres.
- Verificar se a senha contém pelo menos uma letra maiúscula.
- Verificar se a senha contém pelo menos uma letra minúscula.
- Verificar se a senha contém pelo menos um dígito numérico.
- Verificar se a senha contém pelo menos um caractere especial (e.g, !@#$%).





Developed by Lucas Walim
