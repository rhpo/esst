
Cinema {
	salles Salle[]
}

Salle {
	projections Projection[]
}

Film {
	name string
}

Projection (Salle, Film) {
	heure Heure
}

Heure {
	heure int
	minute int
}
