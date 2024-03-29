CREATE TABLE IF NOT EXISTS regions (
     id int GENERATED ALWAYS AS IDENTITY,
     name_en varchar(1025) NOT NULL,
     name_ru varchar(1025) NOT NULL,
     currency varchar(3) NOT NULL, -- Currency code (ex. USD, BYN, RUB)
     PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users (
     id int GENERATED ALWAYS AS IDENTITY,
     telegram_id text NOT NULL UNIQUE ,
     nickname text,
     name text,
     phone text,
     bio text,
     region_id int,
     is_blocked boolean NOT NULL DEFAULT false,
     PRIMARY KEY (id),
     CONSTRAINT fk_region FOREIGN KEY (region_id) REFERENCES regions(id)
);

CREATE TABLE IF NOT EXISTS platforms (
    id int GENERATED ALWAYS AS IDENTITY,
    name varchar(512) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS games (
     id int GENERATED ALWAYS AS IDENTITY,
     title text NOT NULL,
     publisher text,
     store_game_id text UNIQUE,
     store_price_usd numeric,
     store_page_url text,
     thumbnail_url text,
     platform_id int NOT NULL,
     PRIMARY KEY(id),
     CONSTRAINT fk_platform FOREIGN KEY (platform_id) REFERENCES platforms(id)
);

CREATE TYPE offer_type AS ENUM ('BUY', 'SELL', 'EXCHANGE');

CREATE TABLE IF NOT EXISTS offers (
     id int GENERATED ALWAYS AS IDENTITY,
     game_id int NOT NULL,
     user_id int NOT NULL,
     type offer_type NOT NULL,
     description text,
     price numeric,
     is_active boolean NOT NULL DEFAULT true,
     PRIMARY KEY(id),
     CONSTRAINT fk_game FOREIGN KEY (game_id) REFERENCES games(id),
     CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)
);