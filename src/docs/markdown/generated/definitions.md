## Definitions
### Tag
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|articles||false|Article array||
|id||false|integer (int64)||
|name||false|string||


### Author
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|articles||false|Article array||
|email||false|string||
|firstName||false|string||
|id||false|integer (int64)||
|lastName||false|string||
|phone||false|string||


### Article
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|author||false|Author||
|content||false|string||
|id||false|integer (int64)||
|tags||false|Tag array||
|title||false|string||


