## Paths
### getAllArticles
```
GET /articles
```

#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|404|Not Found|No Content|
|200|OK|Article array|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* articles-controller

### saveArticle
```
POST /articles
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|article|article|true|Article||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|404|Not Found|No Content|
|200|OK|Article|
|201|Created|No Content|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* articles-controller

### getOneArticle
```
GET /articles/{id}
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|id|id|true|integer (int64)||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|404|Not Found|No Content|
|200|OK|Article|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* articles-controller

### getAllAuthors
```
GET /authors
```

#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|404|Not Found|No Content|
|200|OK|Author array|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* authors-controller

### saveAuthor
```
POST /authors
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|author|author|true|Author||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|404|Not Found|No Content|
|200|OK|Author|
|201|Created|No Content|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* authors-controller

### getOneAuthor
```
GET /authors/{id}
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|id|id|true|integer (int64)||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|404|Not Found|No Content|
|200|OK|Author|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* authors-controller

