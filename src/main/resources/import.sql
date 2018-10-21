insert into AUTHORS (id, first_name, last_name, email, phone) values (next value for AUTHORS_SEQ, 'Joel', 'Crosswhite', 'joel.crosswhite@xwhite.us', '8005551212');
insert into AUTHORS (id, first_name, last_name, email, phone) values (next value for AUTHORS_SEQ, 'Chuck', 'Wagon', 'chuck.wagon@xwhite.us', '8005551212');

insert into ARTICLES (id, title, content, author_id) values (next value for ARTICLES_SEQ, 'Hello World!', 'Let''s see how this blog software works.', select id from AUTHORS where email = 'joel.crosswhite@xwhite.us');
insert into ARTICLES (id, title, content, author_id) values (next value for ARTICLES_SEQ, 'Gettin It Started', 'Step 1: Write some words and hit enter', select id from AUTHORS where email = 'joel.crosswhite@xwhite.us');
insert into ARTICLES (id, title, content, author_id) values (next value for ARTICLES_SEQ, 'How To Solve World Hunger', 'I have a perfect plan, but I don''t have space in this margin.', select id from AUTHORS where email = 'joel.crosswhite@xwhite.us');
insert into ARTICLES (id, title, content, author_id) values (next value for ARTICLES_SEQ, 'What Is Right With Computers', 'Here is where everything is right', select id from AUTHORS where email = 'joel.crosswhite@xwhite.us');
insert into ARTICLES (id, title, content, author_id) values (next value for ARTICLES_SEQ, 'What Is Wrong With Computers', 'Have you ever seen "The Terminator"?', select id from AUTHORS where email = 'chuck.wagon@xwhite.us');
insert into ARTICLES (id, title, content, author_id) values (next value for ARTICLES_SEQ, 'Taking The Fifth', 'Just one article too late.', select id from AUTHORS where email = 'joel.crosswhite@xwhite.us');
insert into ARTICLES (id, title, content, author_id) values (next value for ARTICLES_SEQ, 'What Is the Name of the Man on First Base?', 'No, he''s on second.', select id from AUTHORS where email = 'chuck.wagon@xwhite.us');
insert into ARTICLES (id, title, content, author_id) values (next value for ARTICLES_SEQ, 'Why Did the Chicken Cross the Road?', 'To get to the other side.', select id from AUTHORS where email = 'joel.crosswhite@xwhite.us');
insert into ARTICLES (id, title, content, author_id) values (next value for ARTICLES_SEQ, 'Star Wars vs. Star Trek', 'Captain Kirk beats all - need I say more?', select id from AUTHORS where email = 'joel.crosswhite@xwhite.us');
insert into ARTICLES (id, title, content, author_id) values (next value for ARTICLES_SEQ, 'Survivor vs. Big Brother', 'Now that''s just getting silly.', select id from AUTHORS where email = 'joel.crosswhite@xwhite.us');
insert into ARTICLES (id, title, content, author_id) values (next value for ARTICLES_SEQ, '10 Ways to Find Out About Anything', 'Let me know which ways work for you.', select id from AUTHORS where email = 'joel.crosswhite@xwhite.us');
insert into ARTICLES (id, title, content, author_id) values (next value for ARTICLES_SEQ, 'The Truth Behind Cat Videos', 'They''re just so darn cute.', select id from AUTHORS where email = 'chuck.wagon@xwhite.us');
insert into ARTICLES (id, title, content, author_id) values (next value for ARTICLES_SEQ, 'Lucky #13', 'Now I know why skyscrapers skip this floor.', select id from AUTHORS where email = 'joel.crosswhite@xwhite.us');
insert into ARTICLES (id, title, content, author_id) values (next value for ARTICLES_SEQ, 'Where Is the Money In Blogging?', 'Why don''t sponsors want to pay for one sentence articles?', select id from AUTHORS where email = 'joel.crosswhite@xwhite.us');
insert into ARTICLES (id, title, content, author_id) values (next value for ARTICLES_SEQ, 'Say Good Night, Charlie!', 'Good night, Charlie.', select id from AUTHORS where email = 'joel.crosswhite@xwhite.us');

insert into TAGS (id, tag_name) values (next value for TAGS_SEQ, 'fun-post');
insert into TAGS (id, tag_name) values (next value for TAGS_SEQ, 'information');
insert into TAGS (id, tag_name) values (next value for TAGS_SEQ, 'lists');
insert into TAGS (id, tag_name) values (next value for TAGS_SEQ, 'sci-fi');
insert into TAGS (id, tag_name) values (next value for TAGS_SEQ, 'miscelaneous');

insert into ARTICLES_TAGS (article_id, tag_id) values (select id from ARTICLES where title = 'Hello World!', select id from TAGS where tag_name = 'fun-post');
insert into ARTICLES_TAGS (article_id, tag_id) values (select id from ARTICLES where title = 'Gettin It Started', select id from TAGS where tag_name = 'information');
insert into ARTICLES_TAGS (article_id, tag_id) values (select id from ARTICLES where title = 'Gettin It Started', select id from TAGS where tag_name = 'fun-post');
insert into ARTICLES_TAGS (article_id, tag_id) values (select id from ARTICLES where title = 'How To Solve World Hunger', select id from TAGS where tag_name = 'information');
insert into ARTICLES_TAGS (article_id, tag_id) values (select id from ARTICLES where title = 'What Is Right With Computers', select id from TAGS where tag_name = 'lists');
insert into ARTICLES_TAGS (article_id, tag_id) values (select id from ARTICLES where title = 'What Is Wrong With Computers', select id from TAGS where tag_name = 'lists');
insert into ARTICLES_TAGS (article_id, tag_id) values (select id from ARTICLES where title = 'Taking The Fifth', select id from TAGS where tag_name = 'fun-post');
insert into ARTICLES_TAGS (article_id, tag_id) values (select id from ARTICLES where title = 'Taking The Fifth', select id from TAGS where tag_name = 'miscelaneous');
insert into ARTICLES_TAGS (article_id, tag_id) values (select id from ARTICLES where title = 'What Is the Name of the Man on First Base?', select id from TAGS where tag_name = 'fun-post');
insert into ARTICLES_TAGS (article_id, tag_id) values (select id from ARTICLES where title = 'Why Did the Chicken Cross the Road?', select id from TAGS where tag_name = 'fun-post');
insert into ARTICLES_TAGS (article_id, tag_id) values (select id from ARTICLES where title = 'Star Wars vs. Star Trek', select id from TAGS where tag_name = 'sci-fi');
insert into ARTICLES_TAGS (article_id, tag_id) values (select id from ARTICLES where title = 'Survivor vs. Big Brother', select id from TAGS where tag_name = 'miscelaneous');
insert into ARTICLES_TAGS (article_id, tag_id) values (select id from ARTICLES where title = '10 Ways to Find Out About Anything', select id from TAGS where tag_name = 'lists');
insert into ARTICLES_TAGS (article_id, tag_id) values (select id from ARTICLES where title = 'The Truth Behind Cat Videos', select id from TAGS where tag_name = 'fun-post');
insert into ARTICLES_TAGS (article_id, tag_id) values (select id from ARTICLES where title = 'Lucky #13', select id from TAGS where tag_name = 'information');
insert into ARTICLES_TAGS (article_id, tag_id) values (select id from ARTICLES where title = 'Lucky #13', select id from TAGS where tag_name = 'miscelaneous');
insert into ARTICLES_TAGS (article_id, tag_id) values (select id from ARTICLES where title = 'Where Is the Money In Blogging?', select id from TAGS where tag_name = 'information');