# Spring for GraphQL Paging

This repo contains the code for a live coding session I did on: 

- Spring Data JPA
- GraphQL
- Paging & Sorting

The reason I put this together was because I was getting a few questions around how to do
paging in GraphQL. GraphQL is independent of your data layer. I walked through creating 
some data and how to use the paging and sorting repository in Spring Data. From there
your GraphQL query just needs to pass the appropriate arguments to the repository to return
the appropriate results. 

Recording: https://www.twitch.tv/videos/1481210171 



```http request
GET http://localhost:8080/api/people?page=1&size=3&sort=firstName

```

```graphql
query people {
  allPeople {
    # id
    firstName
    lastName
    # phoneNumber
    # email
		address {
      address
			city
			state
      zip
    }
  }
}

query pagedPeople {
  allPeoplePaged(page:0, size: 3) {
    # id
    firstName
    lastName
    # phoneNumber
    # email
		address {
      address
			city
			state
      zip
    }
  }
}
```