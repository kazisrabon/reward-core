
**Reward Point calculation api**

**Tech stack**
- Spring boot
- Spring rest
- Maven
- Mockito and JUnit

**Command to use**

- Building : `mvn clean install`
- Running : `mvn spring-boot:run`


**cURL to get the data**

`curl --location --request GET 'http://localhost:8080/reward/calculate/'`

** Sample response from mock data set**

```json
{
  "rewardsPerUser": [
    {
      "userId": "u1",
      "rewardsPerMonth": [
        {
          "month": 1,
          "rewardPoints": 100
        },
        {
          "month": 2,
          "rewardPoints": 160
        },
        {
          "month": 3,
          "rewardPoints": 0
        }
      ],
      "totalRewardPoints": 260
    },
    {
      "userId": "u2",
      "rewardsPerMonth": [
        {
          "month": 1,
          "rewardPoints": 300
        },
        {
          "month": 2,
          "rewardPoints": 870
        },
        {
          "month": 3,
          "rewardPoints": 70
        }
      ],
      "totalRewardPoints": 1240
    },
    {
      "userId": "u3",
      "rewardsPerMonth": [
        {
          "month": 1,
          "rewardPoints": 110
        },
        {
          "month": 2,
          "rewardPoints": 410
        },
        {
          "month": 3,
          "rewardPoints": 1170
        }
      ],
      "totalRewardPoints": 1690
    },
    {
      "userId": "u4",
      "rewardsPerMonth": [
        {
          "month": 1,
          "rewardPoints": 90
        }
      ],
      "totalRewardPoints": 90
    }
  ]
}
```


